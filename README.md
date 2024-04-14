# GameRuleLib
Library for optionally syncing game rules to the client

## Setup
See [GitHub Packages Documentation](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#using-a-published-package).
Remember to use `modImplementation` and `include`.
```groovy
include modImplementation("com.kevinthegreat1:gamerulelib:version")
```

## Usage
See [`SyncedGameRuleRegistry`](/src/main/java/com/kevinthegreat/gamerulelib/api/v1/SyncedGameRuleRegistry.java). Should mostly be a drop-in replacement for Fabric API's `GameRuleRegistry`.
