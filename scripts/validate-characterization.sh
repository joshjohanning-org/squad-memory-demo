#!/usr/bin/env bash
set -euo pipefail

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
classes_dir="$repo_root/target/characterization-classes"

rm -rf "$classes_dir"
mkdir -p "$classes_dir"

javac --release 17 \
  -d "$classes_dir" \
  $(find "$repo_root/src/main/java" "$repo_root/src/test/java" -name '*.java' -print)

java -cp "$classes_dir" com.example.atlasfx.TradeSubmissionCharacterization
