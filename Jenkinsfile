node('') {
    stage('Clone repository') {
          checkout([$class: 'GitSCM', branches: [[name: '*/arping-2.x']],
          doGenerateSubmoduleConfigurations: false, extensions: [[
                            $class: 'RelativeTargetDirectory',
                            relativeTargetDir: "/buildroot"
                        ]],
          submoduleCfg: [], userRemoteConfigs:
          [[credentialsId: '',
          url: 'https://github.com/ThomasHabets/arping.git']]])
    }

     stage('PREPARE ') {
      sh 'id;sudo  apt-get -y install libnet1-dev libpcap-dev make autoconf automake libtool'

    }

    stage('BUILD') {
      sh 'cd /buildroot && ./bootstrap.sh'
      sh 'cd /buildroot && ./configure && make'
    }

    stage ('TESTS') {
    parallel(
      '1st Tests': {
        echo 'running 1st tests '
      },
      '2st': {
        echo 'running 2st tests'
      }
    )
    }
    stage('PREPARE_ARTIFACT') {
    echo 'PREPARE_ARTIFACT'
    }

    stage('DEPLOY') {
    echo 'DEPLOY'
    }


}