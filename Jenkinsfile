pipeline{

    agent any
    tools { 
        maven 'Maven' 
    }

    stages{
        stage("Clone Git"){
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
            }
        }
    }
}
