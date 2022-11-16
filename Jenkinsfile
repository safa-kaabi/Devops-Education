pipeline {

    agent { label 'maven' }
    

    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "NegraMed2", url: "https://github.com/safa-kaabi/Devops-Education.git";
            }
        }
        stage('Unit Testing : Test Dynamique Junit and  Mockito'){
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
                sh "sudo docker build -t negramed/tpachat .";
            }
        }
        /*
        
        stage("Push Docker image to nexus Private Repo") {
            steps {
                sh "sudo docker login -u admin -p nexus 192.168.110.50:8082/repository/docker-hosted-validation";
                sh "sudo docker tag NegraMed/tpachat 192.168.110.50:8082/docker-hosted-validation/validation";
                sh "sudo docker push 192.168.110.50:8082/docker-hosted-validation/validation";
            }
        }*/
        
        stage('Deploy Artifact to Nexus') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true -Pprod'
            }
        }
    /*
        stage("Build Docker image from nexus repo") {
            steps {
                sh "sudo docker pull 192.168.110.50:8082/docker-hosted-validation/validation";
            }
        }
        
       
    
        stage("Start Containers : with docker compose") {
            steps {
                sh "sudo docker compose up -d";
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
            cleanWs()
        }
    }
}
