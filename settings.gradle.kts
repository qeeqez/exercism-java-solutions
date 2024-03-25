rootProject.name = "exercism-java-solutions"

val subProjects = rootProject.projectDir.listFiles()
    ?.filter { it.isDirectory }
    ?.filterNot { it.name.startsWith(".") }
    ?.filterNot { it.name.equals("gradle") }
    ?.map { it.name }

subProjects?.let { include(it) }