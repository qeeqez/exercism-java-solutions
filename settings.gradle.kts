rootProject.name = "exercism-java-solutions"

val subProjects = rootProject.projectDir.listFiles()
    ?.filterNot { it.name.startsWith(".") }
    ?.filter { it.isDirectory }
    ?.map { it.name }

subProjects?.let { include(it) }