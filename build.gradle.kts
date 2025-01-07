// Top-level build file where you can add configuration options common to all sub-projects/modules.
//Ce bloc définit des plugins à utiliser dans le projet,
//mais avec l'option apply false, ces plugins ne sont pas appliqués directement au niveau global (projet).
//Cela signifie qu'ils sont disponibles pour être utilisés dans les modules spécifiques (comme :app),
//mais pas activés globalement.

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0" apply false
}