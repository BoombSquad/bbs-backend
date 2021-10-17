pipeline{

    agent any
    tools { 
        maven 'Maven' 
    }

    stages{
        stage("Clone Git (backend)"){
            steps{
                git branch: 'develop', credentialsId: 'c58e8b1d-28ce-4c93-9c02-44a50d00b70a', url: 'https://github.com/BoombSquad/bbs-backend.git'
            }
        }
        stage("Compile"){
            steps{
                sh 'mvn clean compile'
            }
        }
        stage("Test"){
            steps{
                sh 'mvn test'
            }
        }
        stage("Build"){
            steps{
                sh 'mvn install'
                sh 'cp -r /var/lib/jenkins/.m2/repository/com/eng-software/bbs-backend/2.3.0/bbs-backend-2.3.0.war /home/vagrant/'
            }
        }
        stage("Clone Git (frontend)"){
            steps{
                git branch: 'develop', credentialsId: 'c58e8b1d-28ce-4c93-9c02-44a50d00b70a', url: 'https://github.com/BoombSquad/bbs-front.git'
            }
        }
        stage("Deploy into apache2"){
            steps{
                sh 'cp -r /var/lib/jenkins/workspace/bbs-backend-pipeline/* /var/www/html/'
            }
        }
    }
}
