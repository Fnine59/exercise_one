## 安卓基础期中测验练习

#### 项目效果及基本要求

![requirement](https://s1.ax1x.com/2018/04/14/CZEz6K.png "requirement")

#### 功能说明

1. 选择spinner中的选项时，下方的列表会刷新

2. 可以在输入框中输入关键字，点击查询图标按钮进行查询并显示在下方列表中

#### 注意点

1. 在当前产品类别下，查询其他类别的商品是查询不到的

2. 如果输入框中有内容，在切换spinner选项时也会进行查询。因此，比如在食物选项卡中查询“电视”，应当没有任何结果，但如果此时将类别切换到家电，则会显示结果并且只有匹配的结果而不是显示家电分类中的所有商品。

#### 源数据

```
<string-array name="prodArr">
    <item>可口可乐CocaCola</item>
    <item>皮制箱leatherBox</item>
    <item>统一泡面instantnoodles </item>
    <item>Tcl电视</item>
    <item>金士顿U盘</item>
    <item>中国简史brief history of China </item>
    <item>朗科U盘Netac</item>
    <item>海尔空调air conditioner</item>
    <item>张裕红酒 red wine</item>
    <item>MP3播放器</item>
    <item>吸类器suction trap</item>
    <item>油烟机 lampblack machine</item>
    <item>口香糖Chewing gum</item>
    <item>唐诗三百首three hundred poems of Tang Dynasty</item>
    <item>拉杆箱pull rod box</item>
</string-array>

<string-array name="catArr">
    <item>食品</item>
    <item>箱包</item>
    <item>食品</item>
    <item>家电</item>
    <item>数码</item>
    <item>图书</item>
    <item>数码</item>
    <item>家电</item>
    <item>食品</item>
    <item>数码</item>
    <item>家电</item>
    <item>家电</item>
    <item>食品</item>
    <item>图书</item>
    <item>箱包</item>
</string-array>

<array name="prodImg">
    <item>@drawable/america</item>
    <item>@drawable/australia</item>
    <item>@drawable/portugle</item>
    <item>@drawable/portugle</item>
    <item>@drawable/new_zealand</item>
    <item>@drawable/america</item>
    <item>@drawable/australia</item>
    <item>@drawable/america</item>
    <item>@drawable/australia</item>
    <item>@drawable/america</item>
    <item>@drawable/new_zealand</item>
    <item>@drawable/new_zealand</item>
    <item>@drawable/portugle</item>
    <item>@drawable/portugle</item>
    <item>@drawable/america</item>
</array>
```
