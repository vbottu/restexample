pipeline {
    agent any
    triggers{
        pollSCM('')
    }
    tools {
        maven 'mvn-3.5.3'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                script{
                    pom= readMavenPom file: 'pom.xml'
                }
            }
        }

        stage ('Build') {
            
            steps {
                sh 'mvn -DskipTests -Dmaven.test.skip=true  clean compile' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        stage('package'){
            steps{
                sh 'mvn -DskipTests -Dmaven.test.skip=true package'
            }
        }
    }
}
