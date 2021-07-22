node('agent') {

    stage('CHECKOUT') {
     echo "CHECKOUT"
    }

    stage('BUILD') {
     echo "BUILD"
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