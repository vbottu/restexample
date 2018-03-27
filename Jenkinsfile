pipeline {
    agent any
    triggers{
        pollSCM('')
    }
    parameters{
        string(name: 'DOCKER_ID', defaultValue:'',description:'This is the credential id for teh docker credentials')
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
                    env.APPLICATION_NAME=pom.properties['artifactName']
                    env.VERSION=pom.version
                    env.IMAGE_NAME=pom.properties['docker.registry']+"/"+APPLICATION_NAME+":"+VERSION
                    env.DOCKER_HOST="unix:///var/run/docker.sock"
                    env.DOCKER_REGISTRY=pom.properties['docker.registry']
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
                withCredentials([usernamePassword(credentialsId:env.DOCKER_ID, passwordVariable:'password_docker',usernameVariable:'username_docker')]){
                sh '''
                docker login -u ${username_docker} -p ${password_docker} ${DOCKER_REGISTRY}
                docker build -t ${IMAGE_NAME} -f docker/Dockerfile .
                docker push ${IMAGE_NAME}
                docker rmi ${IMAGE_NAME} || true
                '''
                }
            }
        }
    }
}
