package com.tado.timestamped.transform

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import org.codehaus.groovy.transform.GroovyASTTransformationClass

@Retention(RetentionPolicy.RUNTIME)
@Target([ ElementType.TYPE ])
@GroovyASTTransformationClass("com.tado.timestamped.transform.TimestampedTransform")
@interface Timestamped {
   boolean update() default true
   boolean create() default true
   String clazz() default 'org.joda.time.Instant'
}
