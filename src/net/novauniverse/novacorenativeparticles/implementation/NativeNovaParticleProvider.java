package net.novauniverse.novacorenativeparticles.implementation;

import java.util.Collection;
import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import net.zeeraa.novacore.spigot.abstraction.particle.NovaDustOptions;
import net.zeeraa.novacore.spigot.abstraction.particle.NovaParticleProvider;

public class NativeNovaParticleProvider extends NovaParticleProvider {
	@Override
	public void showRedstoneParticle(Location location, NovaDustOptions options) {
		location.getWorld().spawnParticle(Particle.REDSTONE, location.getX(), location.getY(), location.getZ(), 1, new Particle.DustOptions(options.getColor(), options.getSize()));
	}

	@Override
	public void showRedstoneParticle(Location location, NovaDustOptions options, Player receiver) {
		receiver.spawnParticle(Particle.REDSTONE, location.getX(), location.getY(), location.getZ(), 1, new Particle.DustOptions(options.getColor(), options.getSize()));
	}

	@Override
	public void showRedstoneParticle(Location location, NovaDustOptions options, Collection<Player> receivers) {
		Particle.DustOptions data = new Particle.DustOptions(options.getColor(), options.getSize());
		receivers.forEach(receiver -> receiver.spawnParticle(Particle.REDSTONE, location.getX(), location.getY(), location.getZ(), 1, data));
	}

	@Override
	public void showRedstoneParticle(Location location, NovaDustOptions options, Predicate<Player> predicate) {
		Particle.DustOptions data = new Particle.DustOptions(options.getColor(), options.getSize());
		location.getWorld().getPlayers().stream().filter(predicate).forEach(receiver -> receiver.spawnParticle(Particle.REDSTONE, location.getX(), location.getY(), location.getZ(), 1, data));
	}
}