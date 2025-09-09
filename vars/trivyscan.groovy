def call(String fsName){
  sh "trivy fs . --format table -o ${fsName}"
}
