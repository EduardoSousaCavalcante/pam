package com.example.appaula

import android.app.Application
import com.example.appaula.data.AppContainer
import com.example.appaula.data.AppDataContainer

// Classe principal da aplicação
// Precisa estar definida no AndroidManifest.xml
// android:name=".EmpresaApplication"
class EmpresaApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
