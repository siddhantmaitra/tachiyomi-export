# Tachiyomi-export

Java code to convert backups from the [Tachiyomi](https://tachiyomi.org/) android app into `json`.

## Why
* [Tachiyomi is no longer supported](https://tachiyomi.org/news/2024-01-13-goodbye).
* I want to move my library to other apps.
* I could not find a web-tool or CLI that would do it for me, so trying my hand at it.
* Protobufs are something new to me.

## Setup
0. Clone repo
1. Ensure `java`, `mvn`,`protoc` are installed
2. Run the following command to generate data access class:
	```sh
	 protoc --java_out=output/path <FILE>.proto
	```
3. Put the generated `.java` file with `App.java`
4. Run `mvn install` in project root to setup
5. Open `App.java`. Setup the path of backup file and output file.
6. Run `mvn exec:java` to run `App.java`

## Status
* It is a barebone PoC that converts backup files to `.json`. Not that useful yet.
* Correctness of `.proto` file is unknown (made it by reading source code of the app and guessing). Thus, parity of backup file and json is unknown.
* Supported backup file format: `.proto.gz` or `.tachibk` or `.gz`.
