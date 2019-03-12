workspace(name = "intellij_with_bazel")

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:jvm.bzl", "jvm_maven_import_external")

# Long-lived download links available at: https://www.jetbrains.com/intellij-repository/releases

# The plugin api for IntelliJ 2018.3. This is required to build IJwB,
# and run integration tests.
http_archive(
    name = "intellij_ce_2018_3",
    build_file = "@//intellij_platform_sdk:BUILD.idea",
    sha256 = "8eb5a2a2544607b2b052c5961475528a3f981333b301e0e17ad0e76eec8ac6a8",
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/2018.3.5/ideaIC-2018.3.5.zip",
)

# The plugin api for IntelliJ UE 2018.3. This is required to run UE-specific
# integration tests.
http_archive(
    name = "intellij_ue_2018_3",
    build_file = "@//intellij_platform_sdk:BUILD.ue",
    sha256 = "fc8e4fd5801e0675e46354b7eaeac962c0dc713658583e2e87fec2cfdfa0c297",
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIU/2018.3.5/ideaIU-2018.3.5.zip",
)

# The plugin api for CLion 2018.3. This is required to build CLwB,
# and run integration tests.
http_archive(
    name = "clion_2018_3",
    build_file = "@//intellij_platform_sdk:BUILD.clion",
    sha256 = "963fb343272e5903ac7dc944cc64ea9541ab4c150cc4ea796dcb0fb613bff4fd",
    url = "https://download.jetbrains.com/cpp/CLion-2018.3.4.tar.gz",
)

# Python plugin for Android Studio 3.3. Required at compile-time for python-specific features.
http_archive(
    name = "python_2018_2",
    build_file_content = "\n".join([
        "java_import(",
        "    name = 'python',",
        "    jars = ['python-ce/lib/python-ce.jar'],",
        "    visibility = ['//visibility:public'],",
        ")",
    ]),
    sha256 = "863d8da8a6e1d2589178ed2ff657d935ed2536d26bde5ebd7785ca16ce0b3093",
    url = "https://plugins.jetbrains.com/files/7322/48707/python-ce-2018.2.182.3911.36.zip",
)

# Python plugin for IntelliJ CE 2018.3. Required at compile-time for python-specific features.
http_archive(
    name = "python_2018_3",
    build_file_content = "\n".join([
        "java_import(",
        "    name = 'python',",
        "    jars = ['python-ce/lib/python-ce.jar'],",
        "    visibility = ['//visibility:public'],",
        ")",
    ]),
    sha256 = "15969495651d8fcb6e3ae7ea33ef1b15ed62a7a929b016f6ec389a217fdad1d6",
    url = "https://plugins.jetbrains.com/files/7322/52274/python-ce-2018.3.183.4284.148.zip",
)

# Go plugin for IntelliJ UE. Required at compile-time for Bazel integration.
http_archive(
    name = "go_2018_3",
    build_file_content = "\n".join([
        "java_import(",
        "    name = 'go',",
        "    jars = glob(['intellij-go/lib/*.jar']),",
        "    visibility = ['//visibility:public'],",
        ")",
    ]),
    sha256 = "3bcab5174d20363cd3f91302b32d0e9d3114533397d70ed03084e5ac8dbe5d66",
    url = "https://plugins.jetbrains.com/files/9568/52280/intellij-go-183.4284.148.1556.zip",
)

# Scala plugin for IntelliJ CE 2018.3. Required at compile-time for scala-specific features.
http_archive(
    name = "scala_2018_3",
    build_file_content = "\n".join([
        "java_import(",
        "    name = 'scala',",
        "    jars = glob(['Scala/lib/*.jar']),",
        "    visibility = ['//visibility:public'],",
        ")",
    ]),
    sha256 = "37df62f82f3673950a6175232c9161d39b04ccfcd70ba651afddf0c5a1a3c935",
    url = "https://plugins.jetbrains.com/files/1347/50892/scala-intellij-bin-2018.3.2.zip",
)

http_archive(
    name = "android_studio_3_3",
    build_file = "@//intellij_platform_sdk:BUILD.android_studio",
    sha256 = "82603100f772baf5b6b54532375ada756b4b2dc11854cabae267cd8bd8c4f039",
    url = "https://dl.google.com/android/studio/ide-zips/3.3.1.0/android-studio-ide-182.5264788-linux.zip",
)

http_archive(
    name = "android_studio_3_4",
    build_file = "@//intellij_platform_sdk:BUILD.android_studio",
    sha256 = "6f4d1131ccf1deb82104a6b3b7a0d1c1d3a5b5ae35b2d8011cb4b07d9458a967",
    url = "https://dl.google.com/android/studio/ide-zips/3.4.0.15/android-studio-ide-183.5341121-linux.zip",
)

# LICENSE: Common Public License 1.0
jvm_maven_import_external(
    name = "junit",
    artifact = "junit:junit:4.12",
    artifact_sha256 = "59721f0805e223d84b90677887d9ff567dc534d7c502ca903c0c2b17f05c116a",
    licenses = ["notice"],  # Common Public License 1.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "jsr305_annotations",
    artifact = "com.google.code.findbugs:jsr305:3.0.2",
    artifact_sha256 = "766ad2a0783f2687962c8ad74ceecc38a28b9f72a2d085ee438b7813e928d0c7",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "truth",
    artifact = "com.google.truth:truth:0.30",
    artifact_sha256 = "f4a4c5e69c4994b750ce3ee80adbb2b7150fe39f057d7dff89832c8ca3af512e",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "mockito",
    artifact = "org.mockito:mockito-all:1.9.5",
    artifact_sha256 = "b2a63307d1dce3aa1623fdaacb2327a4cd7795b0066f31bf542b1e8f2683239e",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "objenesis",
    artifact = "org.objenesis:objenesis:1.3",
    artifact_sha256 = "dd4ef3d3091063a4fec578cbb2bbe6c1f921c00091ba2993dcd9afd25ff9444a",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "jarjar",
    artifact = "com.googlecode.jarjar:jarjar:1.3",
    artifact_sha256 = "4225c8ee1bf3079c4b07c76fe03c3e28809a22204db6249c9417efa4f804b3a7",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "auto_value",
    artifact = "com.google.auto.value:auto-value:1.6.2",
    artifact_sha256 = "edbe65a5c53e3d4f5cb10b055d4884ae7705a7cd697be4b2a5d8427761b8ba12",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "auto_value_annotations",
    artifact = "com.google.auto.value:auto-value-annotations:1.6.2",
    artifact_sha256 = "b48b04ddba40e8ac33bf036f06fc43995fc5084bd94bdaace807ce27d3bea3fb",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

jvm_maven_import_external(
    name = "error_prone_annotations",
    artifact = "com.google.errorprone:error_prone_annotations:2.3.0",
    artifact_sha256 = "524b43ea15ca97c68f10d5f417c4068dc88144b620d2203f0910441a769fd42f",
    licenses = ["notice"],  # Apache 2.0
    server_urls = ["http://central.maven.org/maven2"],
)

# LICENSE: The Apache Software License, Version 2.0
# proto_library rules implicitly depend on @com_google_protobuf//:protoc
http_archive(
    name = "com_google_protobuf",
    sha256 = "9510dd2afc29e7245e9e884336f848c8a6600a14ae726adb6befdb4f786f0be2",
    strip_prefix = "protobuf-3.6.1.3",
    urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.6.1.3.zip"],
)

# LICENSE: The Apache Software License, Version 2.0
# java_proto_library rules implicitly depend on @com_google_protobuf_java//:java_toolchain
# It's the same repository as above, but there's no way to alias them at the moment (and both are
# required).
http_archive(
    name = "com_google_protobuf_java",
    sha256 = "9510dd2afc29e7245e9e884336f848c8a6600a14ae726adb6befdb4f786f0be2",
    strip_prefix = "protobuf-3.6.1.3",
    urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.6.1.3.zip"],
)

http_archive(
    name = "android_studio_3_4",
    build_file = "@//intellij_platform_sdk:BUILD.android_studio",
    sha256 = "d99718ad7090329712042c2725dafccf7f0be56e2c7017db9727f129b1576757",
    url = "https://dl.google.com/android/studio/ide-zips/3.4.0.11/android-studio-ide-183.5240537-linux.zip",
)

# BEGIN-EXTERNAL-SCALA
# LICENSE: The Apache Software License, Version 2.0
git_repository(
    name = "io_bazel_rules_scala",
    commit = "326b4ce252c36aeff2232e241ff4bfd8d6f6e071",
    remote = "https://github.com/bazelbuild/rules_scala.git",
)

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")

scala_repositories()

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")

scala_register_toolchains()
# END-EXTERNAL-SCALA

# BEGIN-EXTERNAL-KOTLIN
# LICENSE: The Apache Software License, Version 2.0
git_repository(
    name = "io_bazel_rules_kotlin",
    commit = "cab5eaffc2012dfe46260c03d6419c0d2fa10be0",
    remote = "https://github.com/bazelbuild/rules_kotlin.git",
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories")

kotlin_repositories()
# END-EXTERNAL-KOTLIN
