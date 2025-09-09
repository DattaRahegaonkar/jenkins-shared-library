def call(String imageName, String reportName, String tagName) {
  def reportNameNew = "${reportName}-${buildNumber}.html"
  sh "trivy image ${imageName}:${tagName} --format table -o ${reportNameNew} --exit-code 0 --severity HIGH,CRITICAL || true"

  archiveArtifacts artifacts: reportName, allowEmptyArchive: true
}
