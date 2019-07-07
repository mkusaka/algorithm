import numpy as np

class Perceptron(object):
  """
  @params eta float
    学習率
  @params n_iter int
    トレーニング回数
  @param random_state int
    初期化の乱数シード

  @params w_ array
    適合後の重み
  @params errors_ array
    エポックでの誤分類数
  """

  def __init__(self, eta=0.01, n_iter=50, random_state=1):
    self.eta = eta
    self.n_iter = n_iter
    self.random_state = random_state

  def fit(self, X, y):
    """
    @params X data struct, shape = [n_samples, n_featuers]

    @params Y data struct, shape = [n_samples]

    @returns self object
    """
    rgen = np.random.RandomState(self.random_state)
    self.w_ = rgen.normal(loc=0.0, scale=0.01, size=1 + X.shape[1])
    self.errors_ = []

    for _ in range(self.n_iter): # トレーニング回数分のデータ反映
      errors = 0
      for xi, target in zip(X, y):
        # 重みの更新
        update = self.eta * (target - self.predict(xi))
        self.w_[1:] += update * xi
        # 重みの更新
        self.w_[0] += update # TODO: なんで0だけ他になってるんだっけ？
        errors += int(update != 0.0)
      # 反復回数ごとの誤差
      self.errors_.append(errors)
    return self

  def net_input(self, X):
    """
    総入力の計算
    """
    return np.dot(X, self.w_[1:]) + self.w_[0] # そうか、w_[0]はバイアスだ

  def predict(self, X):
    """
    1ステップ後のクラスラベル
    """
    return np.where(self.net_input(X) >= 0.0, 1, -1)




