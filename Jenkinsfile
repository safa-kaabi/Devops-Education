pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        
        
      stage(' GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'ranim-test', url: 'https://github.com/safa-kaabi/Devops-Education.git'          
            }
        }
        stage('CLEANING THE PROJECT') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        }
        stage('ARTIFACT CONSTRUCTION') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
               stage ('JUnit TEST') {
steps {
echo "Maven Test JUnit";
/*sh 'mvn test';*/
}
}
stage('compile project') {
             steps {
                sh 'mvn compile -DskipTests'
      }
        }
        stage('SONAR') {
            steps{
                sh "mvn sonar:sonar -Dsonar.projectKey=ranim -Dsonar.host.url=http://192.168.1.17:9000 -Dsonar.login=524d68ac4e7bbd373f5c6e6d559cd1a20f4d6300 "
            }
                
            }  
         stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipStaging=true -Dmaven.deploy.skip=true -Dmaven.deploy.skip=false -DskipTests'
            }
        }
   
    stage('EMAIL ALERT') {
        steps{
           emailext body: 'your pipeline was successfully built ! everything is good  ', subject: 'build done', to: 'ranim.benafia@esprit.tn'
        }
    }
	     stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
           
           sh 'docker build -t rranim/devops:latest .'
           sh 'docker push rranim/devops:latest'
         }
       }
     }   
	    stage('Start container') {
             steps {
                sh 'docker-compose -v'
                sh 'docker-compose up -d '
                sh 'docker-compose ps'
      }
        }
    }
   
}