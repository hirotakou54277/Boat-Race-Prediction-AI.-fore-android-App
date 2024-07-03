# Boat Race Prediction App
We are developing AI forecasting software for boat races that runs on android. It is still in the process of production.
This project is a Boat Race Prediction App built using Android and TensorFlow. The app predicts the outcomes of boat races based on various input features using a trained machine learning model.
AI Model Results　Recovery Rate: 87.70%, Win Rate: 19.34%.
These are the results for six months with 300 yen 

## Features

- Predict outcomes of boat races
- Uses TensorFlow Lite for on-device machine learning predictions
- Scrapes data from the official boat race website
- Displays prediction results within the app

## Screenshots

![Home Screen](path/to/home_screen.png)
![Race Prediction](path/to/race_prediction.png)

## Installation

To run this project locally, follow these steps:

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/boatrace-prediction-app.git
    cd boatrace-prediction-app
    ```

2. Open the project in Android Studio.

3. Build the project:
    - Make sure you have Android SDK and NDK installed.
    - Sync the project with Gradle files.
    - Build the project.

4. Run the app on an Android device or emulator.

## Usage

1. Launch the app on your Android device.
2. Select a venue from the list.
3. Select a race number to get predictions.
4. View the prediction results on the screen.

## Model Training

The machine learning model was trained using historical race data. The training code is written in Python and uses TensorFlow. The trained model is then converted to TensorFlow Lite format and included in the Android app.

### Training the Model

1. Install required dependencies:
    ```sh
    pip install -r requirements.txt
    ```

2. Run the training script:
    ```sh
    python train_model.py
    ```

3. Convert the trained model to TensorFlow Lite format:
    ```sh
    python convert_model_to_tflite.py
    ```

4. Copy the `model.tflite` file to the `assets` directory of the Android project.

## Contributing

Contributions are welcome! Please read the [CONTRIBUTING.md](CONTRIBUTING.md) file for more information on how to get started.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Acknowledgements

- [TensorFlow](https://www.tensorflow.org/)
- [Jsoup](https://jsoup.org/)
- [Android Studio](https://developer.android.com/studio)

## Contact

If you have any questions or suggestions, please feel free to contact me at [pothos02@gmail.com](mailto:pothos02@gmail.com).

# ボートレース予想アプリ
androidで動作するボートレースのAI予想ソフトを開発中です。まだ製作途中です。
このプロジェクトは、AndroidとTensorFlowを使って作られたボートレース予測アプリです。このアプリは、訓練された機械学習モデルを使用して、様々な入力特徴に基づいてボートレースの結果を予測します。AIモデルの結果 回収率 87.70%、勝率 19.34%.
１レース300円購入で半年間の成績です。

## 特徴

- ボートレースの結果を予測
- デバイス上での機械学習予測にTensorFlow Liteを使用
- ボートレースの公式ウェブサイトからデータをスクレイピング
- 予測結果をアプリ内に表示

## スクリーンショット

![ホーム画面](path/to/home_screen.png)
![レース予想](path/to/race_prediction.png)

## インストール

このプロジェクトをローカルで実行するには、以下の手順に従ってください：

1. リポジトリをクローンする：
    sh
    git clone https://github.com/yourusername/boatrace-prediction-app.git
    cd boatrace-prediction-app
    ```

2. Android Studioでプロジェクトを開きます。

3. プロジェクトをビルドする：
    - Android SDKとNDKがインストールされていることを確認する。
    - プロジェクトをGradleファイルと同期します。
    - プロジェクトをビルドします。

4. Androidデバイスまたはエミュレーターでアプリを実行する。

## 使い方

1. Android端末でアプリを起動する。
2. リストから会場を選択。
3. レース番号を選択すると、予想が表示されます。
4. 予想結果を画面に表示します。

## モデルのトレーニング

機械学習モデルは、過去のレースデータを使ってトレーニングされた。学習コードはPythonで記述され、TensorFlowを使用する。学習されたモデルはTensorFlow Lite形式に変換され、Androidアプリに含まれる。

### モデルのトレーニング

1. 必要な依存関係をインストールする：
    ``sh
    pip install -r requirements.txt
    ```

2. トレーニングスクリプトを実行します：
    以下のスクリプトを実行します。
    python train_model.py
    ```

3. 学習したモデルをTensorFlow Lite形式に変換する：
    sh
    python convert_model_to_tflite.py
    ```

4. model.tflite`ファイルをAndroidプロジェクトの`assets`ディレクトリにコピーする。

## コントリビュート

貢献は大歓迎です！CONTRIBUTING.md](CONTRIBUTING.md)ファイルをお読みください。

## ライセンス

このプロジェクトのライセンスはMITライセンスです。詳細は[LICENSE](LICENSE)ファイルを参照してください。

## 謝辞

- TensorFlow](https://www.tensorflow.org/)
- Jsoup](https://jsoup.org/)
- Android Studio](https://developer.android.com/studio)

## 連絡先

ご質問やご提案がありましたら、[pothos02@gmail.com](mailto:pothos02@gmail.com) までお気軽にご連絡ください。
