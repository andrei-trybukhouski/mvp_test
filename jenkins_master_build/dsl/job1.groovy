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
