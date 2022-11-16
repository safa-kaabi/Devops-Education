pipeline {

    agent { label 'maven' }
    environment{ 
        DOCKERHUB_CREDENTIALS=credentials('docker')
    }

    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "safa_branch", url: "https://github.com/safa-kaabi/Devops-Education.git";
            }
        }
        stage(' JUNIT Mochito '){
            steps {
                sh "mvn clean test -Ptest";
            }
        }

        stage("Sonar") {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login="admin" -Dsonar.password="sonar" -Ptest'
            }
        }

        stage("Build") {
            steps {
                sh "mvn clean package -Pprod";
            }
        }

        stage("Docker image") {
            steps {
                sh "sudo docker build -t safakaabi/tpachat .";
            }
        }
        
        stage('Nexus') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true -Pprod'
            }
        }
        
        /*stage('Deploy Image to DockerHub') {
            steps {
		sh 'echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin';
                sh 'sudo docker push safakaabi/tpachat';
            }
        }*/

        stage("Docker compose") {
            steps {
		sh "sudo docker stop mysqldb tpachat";
		sh "sudo docker rm mysqldb tpachat";
                sh "sudo docker compose up -d";
            	sh "sudo docker ps";
	    }
        }

        /*stage("docker compose down") {
            steps {
                sh "sudo docker compose down";
            }
        }*/
    }
    post {
        always {
	      mail to: 'safa.kaabi@esprit.tn',subject: "Status of pipeline: ${currentBuild.fullDisplayName}",body: "${env.BUILD_URL} has result ${currentBuild.result}
	     cleanWs()
        }
    }
}
