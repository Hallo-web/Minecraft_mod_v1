package attempt.v1;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class ExplodingChickens {
    public static void register() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity, causedByPlayer) -> {
            if(killedEntity.getType() == EntityType.CHICKEN) {
                if(world instanceof ServerWorld serverWorld) {
                    serverWorld.createExplosion(
                            null,
                            killedEntity.getX(),
                            killedEntity.getY(),
                            killedEntity.getZ(),
                            3.0f,
                            false,
                            World.ExplosionSourceType.MOB
                    );
                }
            }
        });
    }
}
