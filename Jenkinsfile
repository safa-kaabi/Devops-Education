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
		sh "sudo docker stop bcb7ca6fc9368214741945927fc10084e69ef20784b48edbf4d26cf5116a748a";
		sh "sudo docker rm bcb7ca6fc9368214741945927fc10084e69ef20784b48edbf4d26cf5116a748a";
		sh "sudo docker stop 11132225a77d75b5fcda0691dbb39a08cad2f9b50de7b84c256735d6147baaf6";
		sh "sudo docker rm 11132225a77d75b5fcda0691dbb39a08cad2f9b50de7b84c256735d6147baaf6";
                sh "sudo docker compose up -d";
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
