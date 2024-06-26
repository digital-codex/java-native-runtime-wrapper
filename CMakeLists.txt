cmake_minimum_required(VERSION 3.26)
project(NativeRuntimeWrapper C)

set(CMAKE_C_STANDARD 17)
set(CMAKE_CXX_STANDARD 17)

set(
		SOURCES
		${CMAKE_CURRENT_SOURCE_DIR}/src/main/c/NativeRuntimeWrapper.c
		${CMAKE_CURRENT_SOURCE_DIR}/src/main/c/InterfaceRequest.c
)

set(
		INCLUDES
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_FileControl.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_InterfaceRequest.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_IOControl.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_IOControl.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_NativeRuntimeWrapper.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_StandardIO.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_StandardLibrary.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_Strings.h
		${CMAKE_CURRENT_SOURCE_DIR}/target/include/dev_codex_java_runtime_unix_UnixStandard.h
)

add_custom_target(
		library-directory ALL COMMAND
		${CMAKE_COMMAND} -E make_directory ${CMAKE_CURRENT_SOURCE_DIR}/target/library
)
set(
		CMAKE_LIBRARY_OUTPUT_DIRECTORY
		${CMAKE_CURRENT_SOURCE_DIR}/target/library
)

add_library(NativeRuntimeWrapper SHARED ${SOURCES} ${INCLUDES})
target_include_directories(
		NativeRuntimeWrapper PRIVATE
		${CMAKE_CURRENT_SOURCE_DIR}/target/include
		$ENV{JAVA_HOME}/include $ENV{JAVA_HOME}/include/linux
)