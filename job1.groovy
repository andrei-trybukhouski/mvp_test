job("Job1"){
    description("First job")
    authenticationToken('secret')
    label('dynamic')
    scm {
        github('*********', 'master')
    }
    triggers {
        gitHubPushTrigger()   
    }
    steps {
        shell ('''
    echo "test"
''')
    }
}
buildPipelineView('project-A') {
    title('MVP Project Pipeline')
    displayedBuilds(5)
    selectedJob('Job1')
    showPipelineParameters()
    refreshFrequency(60)
}