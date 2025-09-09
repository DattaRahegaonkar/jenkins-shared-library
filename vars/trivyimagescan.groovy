def call(String imageName, String reportName) {
  def reportNameNew = "${reportName}-${env.BUILD_NUMBER}.html"
  sh "trivy image ${imageName} --format table -o ${reportNameNew} --exit-code 0 --severity HIGH,CRITICAL || true"
}
