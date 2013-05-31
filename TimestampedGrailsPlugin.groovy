class TimestampedGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]
    
    // If present, lets joda-time take the lead...
    def loadAfter = ['joda-time']
    
    // AST Transforms are less problematic when distributed as precompiled sources
    def packaging = "binary"

    // TODO Fill in these fields
    def title = "Timestamped Plugin" // Headline display name of the plugin
    def author = "Diego Toharia"
    def authorEmail = "diego@toharia.com"
    def description = '''\
This plugin provides an annotation to create the autotimestamping properties using a \
configurable, joda-time compatible AST transform.
'''

    // URL to the plugin's documentation
    def documentation = "http://deigote.github.io/grails-timestamped/"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "GPL3"

    // This plugin was developed by Diego Toharia in his spare time, but with the main goal of
    // using it in the company he works for, tado GmbH, which supported the plugin development
    // by providing resources and most important, a job for the plugin developer :-) 
    def organization = [ name: "tado GmbH", url: "http://tado.com/" ]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "Github", url: "https://github.com/deigote/grails-timestamped/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/deigote/grails-timestamped/" ]
}
