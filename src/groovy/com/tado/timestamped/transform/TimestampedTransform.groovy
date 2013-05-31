package com.tado.timestamped.transform

import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.syntax.SyntaxException
import org.codehaus.groovy.control.messages.SyntaxErrorMessage
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.ast.builder.AstBuilder

import java.lang.annotation.Annotation
import java.lang.reflect.Modifier

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
public class TimestampedTransform implements ASTTransformation
{
   private final static String configurationErrorMessage =
      "Transformation ${TimestampedTransform.class.name} can only go along with ${Timestamped.class.name} anannotation, but found "
   private final static String unexpectedErrorMessage =
      "Unexpected error when applying transformation ${TimestampedTransform.class.name} to class "

   void visit(ASTNode[] astNodes, SourceUnit sourceUnit, List astNodesList = Arrays.asList(astNodes)) {
      AnnotationNode annotationNode = astNodesList.find { it instanceof AnnotationNode }
      ClassNode classNode = astNodesList.find { it instanceof ClassNode }
      Class timestampClass = findTimestampClass(annotationNode)
      try {
         if (annotationNode.classNode?.name == Timestamped.class.name) {
            if (!Modifier.isAbstract(classNode.getModifiers())) { 
               findPropertiesToAdd(annotationNode).each { 
                  timestampProperty -> 
                  println "Adding $timestampProperty of class $timestampClass to $classNode"
                  classNode.addProperty(timestampProperty, Modifier.PUBLIC, 
                     new ClassNode(timestampClass), null, null, null)
               }
            }
         }
         else {
            addError(sourceUnit, configurationErrorMessage + annotationNode?.classNode.name , annotationNode)
         }
      }
      catch (t) {
         addError(sourceUnit, unexpectedErrorMessage + classNode?.name, annotationNode, t)
         t.printStackTrace()
      }
   }
   
   protected void addError(SourceUnit sourceUnit, String msg, ASTNode expr, Throwable cause = null) {
      sourceUnit.getErrorCollector().addErrorAndContinue(new SyntaxErrorMessage(
         new SyntaxException(msg + '\n', expr.getLineNumber(), expr.getColumnNumber()), 
         sourceUnit)
      )
      if (cause) {
         sourceUnit.getErrorCollector().addException(cause, sourceUnit)
      }
   }
   
   private findPropertiesToAdd(AnnotationNode annotation) {
      ['update' : 'lastUpdated', 'create' : 'dateCreated'].findAll { member, property ->
         annotation.members[member] != null ? annotation.members[member].value : true
      }.collect { member, property ->
         property
      }
   }
   
   private findTimestampClass(AnnotationNode annotation) {
      try {
         Class.forName(annotation?.members?.get('clazz')?.value ?: 'org.joda.time.Instant') 
      }
      catch (java.lang.ClassNotFoundException e) {
         java.util.Date
      }
   }
}
