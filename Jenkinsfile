pipeline {
    agent any
    
    stages {
        stage ("Git Checkout"){
            steps{
            git branch: 'yesmine-Branche', 
            url: 'https://github.com/safa-kaabi/Devops-Education.git'
            }
        
        }
        
        stage('Maven Clean') {
            steps {
                echo "Cleaning Project"
                sh 'mvn clean'
            }
        }
        
        stage('Maven Build') {
            steps {
                echo "Building Project"
                sh 'mvn clean install'
            }
        }
        
        stage('Unit Test') {
            steps {
                echo "Testing Project"
                sh 'mvn compile validate test'
            }
        }
        
        stage('Sonarqube Test') {
            steps {
                  echo "Sonarqube Testing "
                  
                withCredentials([string(credentialsId: 'SonarId', variable: 'Sonar')]) {
                      
                      sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=${Sonar}'
                } 
              
                
            }
        }
        
        stage('Create Package') {
            steps {
                echo "Creating Package"
                sh 'mvn package'
            }
        }
        
         stage("Publish to Nexus") {
             steps {
        sh 'mvn deploy'
      }
    
    }
        
    
        stage("Build our Image") {
          steps {
          
              sh 'docker build -t yesminebenmustapha/spring:$BUILD_NUMBER .'
              
             }
       }
       
       stage("Push to DockerHub") { 
            steps { 
                script {
                    
                    withCredentials([string(credentialsId: 'DockerId', variable: 'Docker')]) {
                        sh 'docker login -u yesminebenmustapha -p ${Docker}'
                        sh 'docker image push yesminebenmustapha/spring:$BUILD_NUMBER'
                }
            } 
            }
            
        }
        
        stage("Docker-Compose") {
          steps {
              sh 'docker-compose up -d'
             }
       
       
       } 
      
       
     }
}