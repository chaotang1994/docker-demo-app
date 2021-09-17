pipeline {
    agent any 
    stages {
        stage('Git-Checkout') {
			steps {
				echo "Checking out from Git Repo";
				git branch: 'main', url: 'https://github.com/chaotang1994/docker-demo-app.git'
			}
		}
        stage('Compile and Clean') { 
            steps {

                sh "mvn clean compile"
            }
        }
       

        stage('deploy') { 
            steps {
                sh "mvn package"
            }
        }


        stage('Build Docker image'){
            steps {
              
                sh 'docker build -t  chao4972/dockerdemo:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login'){
            
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u chao4972 -p ${Dockerpwd}"
                }
            }                
        }

        stage('Docker Push'){
            steps {
                sh 'docker push chao4972/dockerdemo:${BUILD_NUMBER}'
            }
        }
        
        stage('Docker deploy'){
            steps {
               
                sh 'docker run -itd -p  8080:8080 chao4972/dockerdemo:${BUILD_NUMBER}'
            }
        }

        
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}