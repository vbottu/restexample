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
        }
        stage('package'){
            steps{
                sh 'mvn -DskipTests -Dmaven.test.skip=true package'
            }
        }
        stage('build'){
            steps{
                withCredentials([usernamePassword(credentialsId:env.dockerid, passwordVariable:'password_docker',usernameVariable:'username_docker')]){
                sh '''
                docker login -u ${username_docker} -p ${password_docker} ${dockerRegistry}
                docker build -t ${IMAGE_NAME} -f docker/Dockerfile .
                docker push ${IMAGE_NAME}
                docker rmi ${IMAGE_NAME} || true
                '''
                }
            }
        }
    }
}
