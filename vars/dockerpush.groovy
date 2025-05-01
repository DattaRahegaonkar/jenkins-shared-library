def call(String DockerCreds, String imageName, String tagName){
  withCredentials([
    usernamePassword(
      credentialsId:DockerCreds,
      usernameVariable:"DockerHubUsername",
      passwordVariable:"DockerHubPassword"
  )]){
    sh "docker login -u ${env.DockerHubUsername} -p ${env.DockerHubPassword}"
    sh "docker image tag ${imageName}:${tagName} ${env.DockerHubUsername}/${imageName}:${tagName}"
    sh "docker push ${env.DockerHubUsername}/${imageName}:${tagName}"
  }
}
