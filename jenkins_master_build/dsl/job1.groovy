pipelineJob('main_job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('andrei-trybukhouski/mvp_test')
                    }
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}
buildPipelineView('project-MVP') {
    title('MVP Project Pipeline')
    displayedBuilds(5)
    selectedJob('main_job')
    showPipelineParameters()
    refreshFrequency(60)
}