class TimestampedGrailsPlugin {
    def version = "0.3"
    def grailsVersion = "2.0 > *"
    
    def loadAfter = ['joda-time']
    
    // def packaging = "binary"

    def title = "Timestamped Plugin"
    def author = "Diego Toharia"
    def authorEmail = "diego@toharia.com"
    def description = 'Provides an annotation to create the autotimestamping properties using a configurable, joda-time compatible AST transform.'

    def documentation = "http://deigote.github.io/grails-timestamped/"

    def license = "GPL3"

    // This plugin was developed by Diego Toharia in his spare time, but with the main goal of
    // using it in the company he works for, tado GmbH, which supported the plugin development
    // by providing resources and most important, a job for the plugin developer :-) 
    def organization = [ name: "tado GmbH", url: "http://tado.com/" ]

    def issueManagement = [ system: "Github", url: "https://github.com/deigote/grails-timestamped/issues" ]

    def scm = [ url: "https://github.com/deigote/grails-timestamped/" ]
}
