pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        
        
      stage(' GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'ranime', url: 'https://github.com/safa-kaabi/Devops-Education.git'          
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
        stage('SONAR') {
            steps{
                sh "mvn sonar:sonar -Dsonar.projectKey=ranim -Dsonar.host.url=http://192.168.1.17:9000 -Dsonar.login=0db83fe295642c63b168562a61af3ec807b49ac0 "
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
    }
    
}
