import pandas as pd
import matplotlib.pyplot as plt 
from tqdm import tqdm 

pd.set_option('display.max_seq_items', 100)
pd.set_option('display.max_rows', 100)
pd.set_option('max_colwidth', 200)

data = pd.read_csv('train_set.csv')

# 1. 画出class分布图
# 2. class分布重新从0开始
# 3. 整理数据，获得低频词dict
# 4. 过滤低频词

def construct_dict(df, d_type='word'):
    word_dict = {}
    corput = df.word_seg if d_type == 'word' else df.article 
    for line in tqdm(corput):
        for e in line.strip().split():
            word_dict[e] = word_dict.get(e,0) + 1 
    return word_dict 

char_dict = construct_dict(data, d_type='char')
word_dict = construct_dict(data, d_type='word')
char_stop_word = [e for e in char_dict if char_dict[e] <= 2]
word_stop_word = [e for e in word_dict if word_dict[e] <= 2]

# ----------------------------------------------------------------------------

def check_len(df):
    s_dct = {}
    for s in df.article:
        s = [e for e in s.split() if e not in char_stop_word]
        s_dct[len(s)] = s_dct.get(len(s), 0) + 1
    l_lst = sorted(s_dct.items(), key=lambda x:x[0], reverse=False)
    sum(s_dct.values())
    p = 0.
    for l in l_lst:
        p += l[1] / sum(s_dct.values())
        print(str(l[0]) + '\t' + str(l[1]) + '\t' + str(p))
check_len(train_df)
# check_len(test_df)
len(train_df)

# ----------------------------------------------------------------------------

def filter_low_freq(df):
    min_freq = 2 
    word_seg_mf2 = []
    char_mf2 = []
    for w in tqdm(df.word_seg):
        word_seg_mf2.append(' '.join([e for e in w.split() if word_dict[e] > min_freq]))
    for w in tqdm(df.article):
        char_mf2.append(' '.join([e for e in w.split() if word_dict[e] > min_freq]))
    df['word_mf2'] = word_seg_mf2
    df['char_mf2'] = char_mf2

filter_low_freq(data)



# 训练词向量
def train_w2v_model(type='article', min_freq=5, size=100):
    sentences = []

    if type == 'char':
        corpus = pd.concat((train_df['article'], test_df['article']))
    elif type == 'word':
        corpus = pd.concat((train_df['word_seg'], test_df['word_seg']))
    for e in tqdm(corpus):
        sentences.append([i for i in e.strip().split() if i])
    print('训练集语料:', len(corpus))
    print('总长度: ', len(sentences))
    model = Word2Vec(sentences, size=size, window=5, min_count=min_freq)
    model.itos = {}
    model.stoi = {}
    model.embedding = {}
    
    print('保存模型...')
    for k in tqdm(model.wv.vocab.keys()):
        model.itos[model.wv.vocab[k].index] = k
        model.stoi[k] = model.wv.vocab[k].index
        model.embedding[model.wv.vocab[k].index] = model.wv[k]

    model.save('../../data/word2vec-models/word2vec.{}.{}d.mfreq{}.model'.format(type, size, min_freq))
    return model
model = train_w2v_model(type='char', size=100)
model = train_w2v_model(type='word', size=100)
# model.wv.save_word2vec_format('../../data/laozhu-word-300d', binary=False)
# train_df[:3]
print('OK')
