def call(String DockerCreds, String imageName, String buildNumber){
  withCredentials([
    usernamePassword(
      credentialsId:DockerCreds,
      usernameVariable:"DockerHubUsername",
      passwordVariable:"DockerHubPassword"
  )]){
    sh "docker login -u ${env.DockerHubUsername} -p ${env.DockerHubPassword}"

    sh "docker image tag ${imageName}:latest ${env.DockerHubUsername}/${imageName}:${buildNumber}"
    sh "docker push ${env.DockerHubUsername}/${imageName}:${buildNumber}"  

    
    sh "docker image tag ${imageName}:latest ${env.DockerHubUsername}/${imageName}:latest"
    sh "docker push ${env.DockerHubUsername}/${imageName}:latest"
  }
}
