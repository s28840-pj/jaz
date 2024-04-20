with import <nixpkgs> {
  config.allowUnfree = true;
};
mkShell {
  packages = [
    openjdk21_headless
    jetbrains.idea-ultimate
  ];
}
