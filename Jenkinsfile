pipeline{
    agent any
     options {
        skipStagesAfterUnstable()
    }
    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerHUBServ')
    }
    tools {
        maven 'M2_HOME'
    }
    stages {
        
        
      stage(' GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'mayssaBranch', url: 'https://github.com/safa-kaabi/Devops-Education.git'          
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
        stage('Sonar') {
             steps {
         	withSonarQubeEnv('sonarQubeServ') { 
         		sh "mvn sonar:sonar"
    	 	}
             }
        }
     /*stage ('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      }
    }*/
    stage('EMAIL ALERT') {
        steps{
           emailext body: 'your pipeline was successfully built ! everything is good  ', subject: 'build done', to: 'mayssa.chaouali@esprit.tn'
        }
    }
	     stage('Building Docker Image'){
 			  steps {
                      sh 'docker build -t mayssachaouali/achat .'
               }
 		}

 		stage('Pushing Docker image') {
             steps {
                 sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                 sh 'docker push mayssachaouali/achat'
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