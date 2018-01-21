
public class Temp {

	private String weblogicJar;
	private String dependincies;
	private String tomcatReplacement;
	private String isCompatible;
	private String solution;
	
		public Temp() {

	}

		public String getWeblogicJar() {
			return weblogicJar;
		}

		public void setWeblogicJar(String weblogicJar) {
			this.weblogicJar = weblogicJar;
		}

		public String getDependincies() {
			return dependincies;
		}

		public void setDependincies(String dependincies) {
			this.dependincies = dependincies;
		}

		public String getTomcatReplacement() {
			return tomcatReplacement;
		}

		public void setTomcatReplacement(String tomcatReplacement) {
			this.tomcatReplacement = tomcatReplacement;
		}

		public String getIsCompatible() {
			return isCompatible;
		}

		public void setIsCompatible(String isCompatible) {
			this.isCompatible = isCompatible;
		}

		public String getSolution() {
			return solution;
		}

		public void setSolution(String solution) {
			this.solution = solution;
		}

		@Override
		public String toString() {
			return "Temp [weblogicJar=" + weblogicJar + ", dependincies=" + dependincies + ", tomcatReplacement="
					+ tomcatReplacement + ", isCompatible=" + isCompatible + ", solution=" + solution + "]";
		}
		

}
