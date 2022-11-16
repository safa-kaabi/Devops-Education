pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerHUBServ')
    }
    stages {
        stage(' GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'mayssaBranch', url: 'https://github.com/safa-kaabi/Devops-Education.git'          
            }
        }*/
        stage('Build') { 
            steps { 
                sh 'mvn -version'
		sh 'mvn clean package' 
            }
        }
        stage ("Launching unit tests"){
 			steps{
 			    echo 'Testing..'
 				sh "mvn test"
 			}
 			
 			}
        stage('Sonar') {
             steps {
         	withSonarQubeEnv('sonarQubeServ') { 
         		sh "mvn sonar:sonar"
    	 	}
             }
        }
     stage ('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      }
    }

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
	
		stage('Run Docker-compose') {
                steps {
                  	sh "docker-compose up -d"
                  	echo "mayssa"
            	}
        }

	
      
    }
}
