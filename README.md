# Kotlin-training003

Kotlin でSpring boot を扱ってみたサンプルです。

## 開発環境

- Windows 11 (21H2)
- IntelliJ IDEA 2023.3.3
- Docker Desktop
- Amazon Corretto version 17.0.3
- spring initializr
  - <https://start.spring.io>

## 実行方法

1. .env ファイルを複製

    ```bash
    cp .env.example .env
    ```

2. Docker コンテナーを起動

    ```bash
    docker-compose up -d
    ```

3. プロジェクトを実行

    ```bash
    ./gradlew bootRun
    ```

4. ブラウザーで <http://localhost:8080> にアクセス

## データベースの確認

docker-compose.yml に、PhpMyAdmin コンテナーを付属させています。

コンテナー起動中に、<http://localhost:8880> へアクセスすると、データベースの確認ができます。
