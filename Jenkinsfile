pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        build 'bbs-backend-build'
      }
    }

    stage('Deploy VM') {
      steps {
        echo 'Passou da Build hein '
      }
    }

    stage('Deploy Artifactory') {
      steps {
        build 'bbs-backend-deploy'
      }
    }

  }
}