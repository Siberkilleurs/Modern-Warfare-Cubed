# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project follows to [Ragnarök Versioning Convention](https://gist.github.com/JustDesoroxxx/5d4a45785ce19a6653ba99f72325c703).

## Modern Warfare Cubed Version 0.1 Changelog - 2024-03-13

### Warning

[**MWC 0.1 NOW REQUIRE RED CORE 0.5.1 AND ABOVE**](https://www.curseforge.com/minecraft/mc-mods/red-core/files/all)

[**MWC 0.1 NOW REQUIRE MIXINBOOTER  AND ABOVE**](https://www.curseforge.com/minecraft/mc-mods/mixin-booter/files/all)

**BEFORE UPDATING TO MWC 0.1 MAKE SURE TO BACKUP YOUR WORLDS, THINGS WILL DISAPPEAR**

### Added

- Custom skins ([Create your own skins guide](https://github.com/Cubed-Development/Modern-Warfare-Cubed/wiki/Custom-Skins))
- Config options:
  - penetratesGlass
  - explosionBreak
  - penetrableBlocks
  - hipFireSpread
  - ammoCounterX 
  - ammoCounterY
  - ammoCounterSize
  - ammoCounterBackgroundReverse
- New BalancePackage Configuration: (You need to regenerate a balance package and modify it again)
  - inaccuracy
  - hipFireSpread
  - hipFireSpreadMultiplier
- Durability to all vests as a temporary measure to resolve vest-related issues
- Smelting of sulfur into gunpowder
- .50 AE in the Ammo Press
- Crafting recipes for the APC9, M1014, Supernova and tactical night vision goggles
- Crafting of grenades (excluding gas grenade) in the ammo press (Once overhauled, they will be moved on the workbench)
- Weapon system version to weapon tooltips
- Added crafting stations to the Creative Tab
- Translations for Chinese, Spanish, and Turkish languages
- GitHub URL in `MCmod.info`
- Proning in single player mode (**Note: Currently unanimated; player will appear standing, will be removed in 0.2**)
- Added new fancy rain splash to go with the fancy rain
- Added remaining time for the craft in the ammunition press
- Custom death Messages when shot with a gun
- Added status messages for `No ammunition`, `No magazine`, `Tracking`, `Firearm mode`, `Zoom` and `Explodes in`
- Added the .277 FURY bullet for the NGSW-R
- Browning Auto 5 now ejects shotgun shells 
- Added `reconcileAmmunition` & `reconcileAttachments` gamerules, they are true by default and should only be used for debugging purposes, for example, when you have weapons that appear to "desync" / glitch out
- Added small delay to inputs after closing a GUI to prevent accidentally shooting weapons
- Added the gold and dark color variants of the Desert Eagle
- Added Hardness values to props
- Added GroovyScript support plugin for workbench and ammo press recipes
- Added icons for empty slot in the equipment inventory
- Added belt slot currently unused

### Changed

- Overhauled the textures of the AAC Honey Badger, Bushmaster ACR, Beowulf, AUG, Remington 870, AS-50, S7-10, M79, HK 417, M16A1, FN F2000, 100rnd 5.56x45mm NATO STANAG Drum Magazine and the pink camo skin
- Overhauled the texture of the Leupold Scope, EOTech Holographic A65 Sight, Aim Point Comp M5 Sight, OKP-7 Sight, Bijia Reflex Sight, RMR Sight, OKP-7 Sight, and Eotech Hybrid HHS™ II Sight
- Overhauled animations and sound effects of the M40A6 and Uzi
- Sidearms can now be carried in backpacks
- Added keybindings to switching cameras on the tablet
- Reworked the config system:
  - Old XML config has been removed, and all configs have been consolidated into a new JSON config. Issues with some non-functioning configs have been resolved
  - Adjusted `craftingmappings.json` to now only override recipes rather than removing all recipes
- Temporarily nerfed all vests as a part of vest problem mitigation
- Nerfed XP gains from smelting ores
- Reloading now only stops once the gun is fully reloaded or no compatible ammunition remains in inventory
- Players in creative mode can now reload without the need for ammunition or magazine (The highest capacity magazine will be selected for weapons with multiple compatible magazines) this can be bypassed by sneaking
- Grenades in creative mode are now infinite 
- Weapons are now rendered in 3D in the inventory. This means there will be a small freeze when opening the Creative Menu. This will be improved over time as we optimize rendering.
- Reduced the stack size of M202 rockets and RPG7 rockets to 4 and 2, respectively
- Increased magazine capacity of bandits on Hard difficulty
- Bullets are now able to penetrate:
  - Standing signs
  - Standing banners
  - End rods
  - Skulls
  - Flower Pots
  - Redstone Comparators
  - Redstone Repeaters
  - Cactus
  - Cake
- Bullets collision has been enhanced to work better with mods
- Updated `MCmod.info` description and credits
- Migrated the config setting for bullets breaking glass into the new config file (ModernWarfareCubed.cfg)
- Forge configuration `Emissive Item Rendering` is now forced to be off (This does not influence Optifine emissive item rendering)
- OptiFine configuration `Fast Render` is now forced to be off
- Changed categories of some weapons
- Magazines are created empty
- Shells life go increased 1606% no performance impact in extreme cases // Todo: This is not supposed to be percent iirc - Luna Lage (Desoroxxx) 2023-12-22
- The position of the bullet when shooting is now centered when aiming
- - Explosive projectiles are now linked to the player who launched them meaning that the kill message will say who killed whom
- Crafting stations (Workbench, Ammunition Press etc...) now display the remaining time with millisecond precision
- Changed default `filmGrain` config from `0.025` to `0.03`
- Changed default `onScreenRainAndSnow` config from `false` to `true`
- Changed default `enableFancyRainAndSnow` config from `false` to `true`
- Changed base fog density from `0.6` to `0.2`
- Explosive projectiles are now linked to the player who launched them, meaning that the kill message will say who killed whom
- Renamed `Armor` creative tab to `Equipment`
- Renamed `Ammunition` creative tab to `Ammunition & Magazines`
- Renamed `Grenades` creative tab to `Throwables`
- Renamed `MWC Camera` and `MWC Tablet` to `Camera` and `Tablet`
- When a thrown camera hits the ground it now only drops the camera item if the thrower is not in creative mode
- Merged the Gadget creative tab into the `Equipment` creative tab
- Debug commands are now only accessible to oped players (Oped of level 4)
- Rewritten the rendering system. Items are now positioned correctly everywhere
- The weapon stats in the modification GUI are now updated instantly
- Terrorist spawns are now lower by default
- Flashbangs do not flash trough walls anymore
- Moved recipe registration from server starting to Registryevent<IRecipes>

### Fixed

- Fixed modifying the number of bullets through memory
- Fixed some issues with incorrect weapon shell throwing
- Fixed the perspective issue with MP7ironsightsstanding
- Fixed entity generation issue (now modifying the entity's health and generation rate requires restarting the game)
- Fixed Minecraft armor making you invulnerable to bullets (less realistic, but they aren't anyway lol)
- Fixed soldiers and terrorists spawning with Minecraft armor
- Fixed issue with config for bullets breaking glass being ignored
- Fixed bullet's being able to penetrate:
  - Glass
  - Glowstone
  - Stacked wooden slabs (2 wooden slabs stacked on top of each other)
- Fixed glitched textures on Backpacks/Vests
- Fixed non-terrorist mobs spawning with guns
- Fixed the issue of mobs not naturally spawning when enabled
- Fixed several faults in en-US.lang
- Fixed crashes caused by certain shaders
- Fixed duplication issues related to copper, gunpowder, and ammo
- Fixed a problem where the carryable inventory tab was shifting the entire inventory to the left for no reasons
- Fixed turrets spawning without weapons
- Fixed 7.62x54mm SVD magazine using 7.62x39mm bullets
- Fixed visual bugs:
  - Fixed 3rd person hovering weapons such as the MP7, CZ-805 Bren, and Python and Taurus revolvers
  - Fixed m249 accessories floating
  - The P90 is no longer compatible with the bipod and the magazine of the terminator conversion kit has been fixed
  - Fixed the attachment of the Long Deagle
  - Fixed m16 stock and m38 front sight on guns like M4A1, Beowulf .50Cal and AR-10
  - Fixed visual bugs with grips on the m40a6 and Malyuk
  - Fixed visual bugs with sight on the Taurus
  - Fixed Stock visual bugs on Origin-12
  - Fixed sights like PSO-1 and OKP-7 on ak-74 and ak-101
  - Fixed the visual bugs of the F2000
  - Adjusted when aiming the HK-P12 with the accessories and re-added the USP Match Compensator accessory
  - Fixed Bipod in ARX-160
  - Fixed Vector Stock Adapter
  - Adjusted slide recoil on m17
  - Fixed muzzle flash for Dragunov, F2000 and AK-101
  - Fixed texture bullet
- Fixed the attachment of the Long Deagle
- Fixed prop hitboxes not lining up with their models:
  - Fridge (open/closed)
  - Locker
  - SCP Locker
  - Dumpster
  - Sandbag
  - Duel Floodlight
  - Single Floodlight
  - Shelf Top
  - Server Rack Top (left/right)
  - Laptop
  - Desk Shelf
  - Desk Shelf (Alt2)
  - Impaled Body
  - Hanging Body
  - Office Chair
  - Office Chair 2
  - Home Chair
  - White Desk Middle
  - Medical Create
  - Camera Rotated
- Fixed unused variable in shader `postflat.frag` causing a crash
- Fixed `20rnd 6.5mm Magazine` using the wrong bullet
- Fixed custom skin system not using the Minecraft missing texture
- Fixed multiple `ResourceLocation`  in the `PostProcessPipeline` being incorrect leading to missing textures
- Fixed fog rendering ignoring if fog should render
- Fixed depth testing being disabled in the world post processing causing issue with first person hand rendering
- Fixed the issue where fog was hardcoded to be disabled
- Fixed world post processing never rendering due to bandage fix
- Fixed world post processing causing a white screen
- Fixed `onScreenRainAndSnow` missing lang entries
- Fixed `enableFancyRainAndSnow` missing lang entries
- Fixed `enableFancyRainAndSnow` having the lang entries for `onScreenRainAndSnow`
- Fixed fancy rain and snow never replacing vanilla rain and snow
- Fixed entities missing a prefix causing collisions with other mods
- Fixed ammunition press animating even when it wasn't actively crafting
- Fixed ammunition press setting the ammunition of the magazines after they where crafted when this isn't necessary anymore
- Fixed tooltip formatting in the ammunition press
- Fixed workbench and ammunition press handling their inventory stack by stack instead of all at once
- Fixed crafting stations GUI not updating after clicking craft showing outdated information
- Fixed crafting stations buttons playing sounds even when disabled
- Fixed crafting stations craft button being enabled even when no crafting recipe was selected
- Fixed crash because of using bad `Pair`
- Fixed position of the backpacks in inventory
- Fixed the client ticker "corruption" state
- Fixed melee attack and heavy melee attack being switched
- Fixed inputs not updating if you switched to another hotbar slot while holding the input
- Fixed oreDictionary not working properly under the craftmappings
- Fixed the height of the Ammo Counter being 1 pixel too high
- Fixed the flashbang missing sound
- Fixed the flashbang missing knockback
- Fixed the flashbang missing particles
- Fixed flashbang not flashing in every direction
- Fixed the exposure decreasing on the client side even when the game is paused
- Fixed spectators being able to shoot weapons
- Fixed the spawning position of the shells
- Bullet spawning maths which was making the bullets spawn in inaccurate position

### Removed

- Removed headshot mechanic; it was currently broken and will come back in the future
- Removed all arcade guns (These will be moved to a sister mod at a later time)
- Removed the SA80
- Removed the mission system
- Removed most of the compatibility layer
- Removed FXAA
- Removed Bloom
- Deleted broken Hescobastion and UMP45GFL props
- Removed the vanilla ability to disable shaders with F4 (this allowed for flash to be disabled)
- Removed the `WIP` status of the flashbang as it is fully usable and reliable

### Optimization

- As a result of a BIG code cleanup, MWC as a whole should now be slightly faster, load slightly faster and use slightly less resources
- As a result of the equipment overhaul, MWC should use less ram and lag less when rendering equipment
- As a result of networking improvements, MWC should use less bandwidth and consume less resources as well as have less latency
- Losslessly compressed assets as a result, the jar size decreased (35.3MB -> 27.57MB)
- Improved ShaderLoader
- Reduced overhead due to the removal of most of the compatibility layer leading to increased performance
- Overhauled the networking, MWC as a whole should be more responsive and use less bandwidth
- Optimized a majority of the models as a result,the jar size decreased (27.57MB -> 21.55MB)

### Internal

- Switched to [Raven](https://github.com/eigenraven) amazing [RetroFuturaGradle](https://github.com/GTNewHorizons/RetroFuturaGradle)
- Now uses Red Core
- Updated to Gradle 8.2
- Cleaned up build.gradle & gradle.properties
- Gradle now automatically updates the version and id in `ModReference.java`
- Updated Forge version
- Improved build times
- Automatically mark some folders as excluded
- Major Refactors
- [WIP] Cleaned up the codebase
- [WIP] Renamed unintelligible variables to more readable names
- Overhauled the internal process of item and block creation
- Changed name and mod id
- Overhauled the networking

### Balance Pack

The new balance pack manager version is `1.3`. 

- Added `inaccuracy`
- Removed `headshotMultiplier`

##### Credits

*Order based on [contributors](https://github.com/Cubed-Development/Modern-Warfare-Cubed/graphs/contributors)*

The whole official Modern Warfare Dev Team:
- [Desoroxxx](https://github.com/Desoroxxx)
- [Stick](https://github.com/SticksDeveloper)
- [Paneedah](https://github.com/Paneedah)
- [Koud_Wind](https://github.com/Koud-Wind)
- [Azurae](https://github.com/azuraerae)

And the people who contributed to Modern Warfare Cubed:
- [strubium](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=strubium&since=2023-02-19&until=2023-05-28)
- [yor42](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=yor42)
- [notdeadpool567](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=notdeadpool567&since=2023-02-19&until=2023-05-28)
- [notdeadpool456](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=notdeadpool456&since=2023-02-19&until=2023-05-28)
- [333mhz](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=333mhz)
- [AhmedKrm](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=AhmedKrm&since=2023-02-19&until=2023-05-28)
- [jbredwards](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=jbredwards)
- [Nogard-00](https://github.com/Cubed-Development/Modern-Warfare-Cubed/commits?author=Nogard-00)
