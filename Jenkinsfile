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
        stage('Unit Testing : Test Dynamique '){
            steps {
                sh "mvn clean test -Ptest";
            }
        }

        stage("SRC Analysis : Test Statique Sonar") {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login="admin" -Dsonar.password="sonar" -Ptest'
            }
        }

        stage("Build Artifact") {
            steps {
                sh "mvn clean package -Pprod";
            }
        }

        stage("Build Docker image") {
            steps {
                sh "sudo docker build -t safakaabi/tpachat .";
            }
        }
        
        stage('Deploy Artifact to Nexus') {
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

        stage("Start Containers : with docker compose") {
            steps {
                sh "sudo docker compose up -d";
            	sh "sudo docker ps";
		sh "sudo docker ps -a";
	    }
        }

        /*stage("docker compose down") {
            steps {
                sh "sudo docker compose down";
            }
        }
        stage("Send Email Notification") {
            steps {
                emailext body: '$DEFAULT_CONTENT', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: '$DEFAULT_SUBJECT'
            }
        }*/
    }
    post {
        always {
            cleanWs()
        }
    }
}
