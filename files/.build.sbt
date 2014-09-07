// coding:utf-8
// Copyright (C) dirlt

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

resolvers ++= Seq(
  "umeng.com" at "http://nexus.umops.com:8088/nexus/content/groups/public/",
  "snapshots" at "http://scala-tools.org/repo-snapshots",
  "releases"  at "http://scala-tools.org/repo-releases", 		  
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Snoatype releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Apache snapshots" at "https://repository.apache.org/content/repositories/snapshots/",
  "Apache releases" at "https://repository.apache.org/content/repositories/releases/",
  "Codehaus snapshots" at "https://nexus.codehaus.org/content/repositories/snapshots",
  "Codehaus releases" at "https://nexus.codehaus.org/content/repositories/releases/",
  "maven.org" at "http://repo1.maven.org/maven2/",
  "java.net" at "http://download.java.net/maven/2/",		  
  "clojars.org" at "http://clojars.org/repo",
  "jboss.com" at "http://repository.jboss.com/maven2",
  "cloudera.com" at "https://repository.cloudera.com/artifactory/cloudera-repos",
  "oracle.com" at "http://download.oracle.com/maven",
  "typesafe releases" at "http://repo.typesafe.com/typesafe/maven-releases",
  "typesafe snapshots" at "http://repo.typesafe.com/typesafe/maven-snapshots"
)

// resolvers += "twitter.com" at "http://maven.twttr.com/"

publishTo <<= (version) { 
  version: String => {
    val umeng_repo = "http://nexus.umops.com:8088/nexus/content/repositories/"
    if (version.trim.endsWith("SNAPSHOT")) Some("umeng.com.snapshots" at umeng_repo + "snapshots/")
    else Some("umeng.com.releases"  at umeng_repo + "releases/")
  }
}
