pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                dir('./app') {
                    sh './gradlew clean test'
                }
            }
        }
        stage('BofBof') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
