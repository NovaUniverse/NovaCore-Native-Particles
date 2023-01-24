package net.novauniverse.novacorenativeparticles;

import org.bukkit.plugin.java.JavaPlugin;

import net.novauniverse.novacorenativeparticles.implementation.NativeNovaParticleProvider;
import net.zeeraa.novacore.commons.log.Log;
import net.zeeraa.novacore.spigot.NovaCore;

public class NovaCoreNativeParticles extends JavaPlugin {
	@Override
	public void onEnable() {
		NovaCore.getInstance().setNovaParticleProvider(new NativeNovaParticleProvider());
		Log.info("NovaCoreNativeParticles", "NovaCore will now use native spigot function to display particles");
	}
}