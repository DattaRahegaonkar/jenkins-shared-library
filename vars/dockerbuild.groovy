def call(String imageName, String tagName, String folderName){
  sh "docker build -t ${imageName}:${tagName} ${folderName}"
}
