
node('master') {
    try {
       notifyStarted()
    
       stage('Clean') {
          deleteDir()
          echo 'Excluir conteudo'
          sh 'ls -la'
          echo 'Conteudo excluido'
       }

       stage('Fetch') {
          checkout scm
       }


       stage('Release') {
          sh """git config --global user.email \"ahrocha@gmail.com\" """
          sh """git config --global user.name \"Andrey Rocha\" """
          sh 'git@github.com:ahrocha/feijoadaweek-site-spring.git'
          sh 'git fetch'
          sh 'git checkout develop'
          sh 'git pull origin develop'
          sh 'git checkout .env'
          sh 'git checkout master'
          sh """echo ${env.BUILD_NUMBER} > build.txt"""
          sh 'git add .'
          sh """git commit -m \"build ${env.BUILD_NUMBER}\" """
          sh 'git merge develop'
          sh 'git push origin master'
          sh """git tag -fa 1.0.1-${env.BUILD_NUMBER} -m \"- build jenkins\" """
          sh """git push origin 1.0.1-${env.BUILD_NUMBER} """
       }

       notifySuccessful()

    } catch (e) {    
       currentBuild.result = "FAILED"
       notifyFailed()
       throw e
    }

}

def notifyStarted() {
    emailext ( 
        subject: "STARTED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]", 
        body: "STARTED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]: Check console output at ${env.BUILD_URL} ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        recipientProviders: [[$class: 'DevelopersRecipientProvider']]
     )
 }

def notifyFailed() {
    emailext (
        subject: "FAILED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        body: "FAILED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]: Check console output at ${env.BUILD_URL} ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}

def notifySuccessful() {
    emailext (
        subject: "SUCCESSFUL: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        body: "SUCCESSFUL: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]: Check console output at ${env.BUILD_URL} ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}
